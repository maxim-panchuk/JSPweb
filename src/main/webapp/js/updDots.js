function updDots (svgArea, radius) {
    let stored = JSON.parse(localStorage.getItem("dots"))

    document.querySelectorAll("circle").forEach(item => item.remove())

    for (let i = 0; i < stored.length; i++) {
        let x = parseFloat(stored[i]["x"])
        let y = parseFloat(stored[i]["y"])

        let xVal = x * (140/radius) + 175
        let yVal = -(y * 140/radius) + 175
        updSVG(svgArea, xVal, yVal)
    }
}