function updSVG (svgArea, x, y) {
    let dot = document.createElementNS("http://www.w3.org/2000/svg", "circle")
    dot.setAttribute("cx", x);
    dot.setAttribute("cy", y);
    dot.setAttribute("r", "3");
    dot.setAttribute("stroke", "#AD2D2D");
    dot.setAttribute("fill", "#AD2D2D");
    svgArea.appendChild(dot)
}