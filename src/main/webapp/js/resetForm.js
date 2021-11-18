function resetForm () {
    const checkBoxes = document.getElementsByClassName("check-box").length
    const radioBtns = document.getElementsByClassName("btn-outline-primary").length

    for (let i = 1; i <= checkBoxes; i++) {
        if (document.getElementById("inlineCheckbox" + i).checked === true) {
            document.getElementById("inlineCheckbox" + i).checked = false
        }
    }

    for (let i = 1; i <= radioBtns; i++) {
        if (document.getElementById("btnradio" + i).checked === true) {
            document.getElementById("btnradio" + i).checked = false
        }
    }

    document.querySelectorAll("circle").forEach(item => item.remove())
    localStorage.setItem("dots", JSON.stringify([]))

    document.getElementById("inputY").value = ""

    data = "[]"
    sendData();
}