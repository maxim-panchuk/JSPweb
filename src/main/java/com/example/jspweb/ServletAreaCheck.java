package com.example.jspweb;

import com.example.jspweb.Logic.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ServletAreaCheck", value = "/ServletAreaCheck")
public class ServletAreaCheck extends HttpServlet {

    ServletContext servletContext;
    Storage storage;
    List<LastDots> lastDotsList = new ArrayList<>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletContext = config.getServletContext();
        this.storage = new Storage();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lastDotsList.clear();
        HttpSession session = request.getSession();
        String body = getBody(request);
        if (!body.equals("")) {
            JSONArray jsonArray = new JSONArray(body);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            for (Object item : jsonArray) {
                RequestObject requestObject = gson.fromJson(item.toString(), RequestObject.class);
                Parameters parameters = new Parameters(requestObject);
                setResults(parameters);
            }
            session.setAttribute("lastDots", lastDotsList);
            session.setAttribute("dots", storage.getStore());
        } else {
            lastDotsList.clear();
            storage.clearStore();
        }

    }

    public static String getBody (HttpServletRequest request) throws IOException {
        String body;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
        body = stringBuilder.toString();
        return body;
    }

    public void setResults (Parameters parameters) {

        StringBuilder rows = new StringBuilder();
        double startTime = System.nanoTime();
        double x = parameters.x;
        double y = parameters.y;
        double r = parameters.r;
        ServerResponse serverResponse;

        boolean bool = x <= 0 && y >= 0 && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= r / 2 ||
                x <= 0 && y <= 0 && x >= -r && y >= -r ||
                x >= 0 && y <= 0 && y >= (x - r);
        String currentTime = new SimpleDateFormat("hh:mm:ss").format(new Date());

        double finishTime = System.nanoTime();
        String execTime = String.format("%4.2f", (finishTime - startTime) / 1000000);

        serverResponse = new ServerResponse(x, y, r, currentTime, execTime, bool);
        LastDots lastDot = new LastDots(serverResponse);
        lastDotsList.add(lastDot);

        storage.addToStore(serverResponse);
        rows.append(toJson(serverResponse));
    }

    private static String toJson (ServerResponse serverResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(serverResponse);
    }
}
