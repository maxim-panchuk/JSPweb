function drawDot (radius, svgArea, rect, event, stored) {

    let dataArr = []

    let xCor = (event.clientX - rect.left)
    let yCor = (event.clientY - rect.top)

    let currentX = (xCor - 175)/(140/radius)
    let currentY = -(yCor - 175)/(140/radius)

    let lastName = parseInt(localStorage.getItem("lastname"))
    localStorage.setItem("lastname", lastName + 1)

    let newdot = new Dot ({
        name:   lastName + 1,
        x:      currentX.toFixed(3),
        y:      currentY.toFixed(3)
    })


    let newDatael = new RequestBody ({
        dot:    newdot,
        radius: radius
    })

    dataArr.push(newDatael)
    //stored.push(newdot)
    //localStorage.setItem("dots", JSON.stringify(stored))

    updSVG(svgArea, xCor, yCor)


    /*sendData(dataArr)
        .then(data => {
            updTbl(data)
        })*/

    sendData(dataArr)
    //console.log(currentX.toFixed(3) + " " + currentY.toFixed(3))
}