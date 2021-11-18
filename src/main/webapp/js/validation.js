function validate () {
    const radioBtnsLength = document.getElementsByClassName("btn-check").length
    const checkBxsLength = document.getElementsByClassName("check-box").length

    function resetForm () {
        for (let i = 1; i <= radioBtnsLength; i++) {
            if (document.getElementById("btnradio" + i).checked === true) {
                document.getElementById("btnradio" + i).checked = false
            }
        }

        document.getElementById("inputY").value = ""

        for (let i = 1; i <= checkBxsLength; i++) {
            if (document.getElementById("inlineCheckbox" + i).checked === true) {
                document.getElementById("inlineCheckbox" + i).checked = false
            }
        }
    }


    let isXselected = false;
    let isYvalid = false;
    let isRselected = false;

    for (let i = 1; i <= radioBtnsLength; i++) {
        if (document.getElementById("btnradio" + i).checked === true) {
            isXselected = true;
        }
    }

    const yVal = document.getElementById("inputY").value;
    if (isNumeric(yVal)) {
        const num = parseFloat(yVal)
        if (num > -5 && num < 3) {
            isYvalid = true;
        }
    }

    for (let i = 1; i <= checkBxsLength; i++) {
        if (document.getElementById("inlineCheckbox" + i).checked === true) {
            isRselected = true;
        }
    }

    if (isXselected && isYvalid && isRselected) {

    } else {
        alert ("Incorrect Input")
        resetForm()
    }
}

function isNumeric(str) {
    if (typeof str != "string") return false
    return !isNaN(str) &&
        !isNaN(parseFloat(str))

}