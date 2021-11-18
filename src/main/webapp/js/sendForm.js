function sendForm(radius, form, svgArea) {
    const x = Array.from(form.querySelectorAll(".check-box"))
    const y = form.querySelector("#inputY")

    const selectedX = x
        .filter(item => item.checked === true)
        .map(item => `${item.value}`)
    const selectedY = y.value

    console.log(selectedX + "    " + selectedY)
    let storedData = JSON.parse(localStorage.getItem("dots"))

    let dataArr = []

    for (let i = 0; i < selectedX.length; i++) {
        let x = selectedX[i] * (140/radius) + 175
        let y = -(selectedY * 140/radius) + 175

        let lastName = parseInt(localStorage.getItem("lastname"))
        localStorage.setItem("lastname", lastName+1)
        let newdot = new Dot ({
            name:   lastName + 1,
            x:      parseFloat(selectedX[i]).toFixed(3),
            y:      parseFloat(selectedY).toFixed(3)
        })

        let newDatael = new RequestBody ({
            dot:    newdot,
            radius: radius
        })

        dataArr.push(newDatael)
        storedData.push(newdot)

        updSVG(svgArea, x, y)
    }


    // После возврата этого промиса, реализовать логику выведения результата

    /*sendData(dataArr)
        .then(data => {
            updTbl(data)
        })*/

    sendData(dataArr)


    localStorage.setItem("dots", JSON.stringify(storedData))
}