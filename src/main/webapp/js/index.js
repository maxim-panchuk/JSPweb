let arr = []
let lastName = -1
localStorage.setItem("dots", JSON.stringify(arr))
localStorage.setItem("lastname", lastName)

const form = document.getElementById("main-form")
const resetBtn = document.getElementById("reset")
const sendBtn = document.getElementById("send")
const r = Array.from(form.querySelectorAll(".btn-check"))
const svgArea = document.getElementById("area-graph")
const rect = svgArea.getBoundingClientRect()
let radius = null

resetBtn.addEventListener("click", resetForm)

sendBtn.addEventListener("click", ()=> {
    validate()
    sendForm(radius, form, svgArea, rect)
})

form.addEventListener("click", event => {
    if (event.target && event.target.matches("input[type='radio']")) {
        radius = r
            .filter(item => item.checked === true)
            .map(item => `${item.value}`)
        updDots(svgArea, radius)

        let neg = document.querySelectorAll(".negative-coords")
        let pos = document.querySelectorAll(".positive-coords")

        pos.forEach(element => {
            element.innerHTML = `${radius}`
        })

        neg.forEach(element => {
            element.innerHTML = `-${radius}`
        })
    }
})
svgArea.addEventListener("click", () => {
    if (radius != null) {
        let storedData = JSON.parse(localStorage.getItem("dots"))
        drawDot(radius, svgArea, rect, event, storedData)
    }

})