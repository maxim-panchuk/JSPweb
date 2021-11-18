function updTbl (data) {
    let array = ["x", "y", "r", "currentTime", "execTime", "bool"]

    const table = document.querySelector(".table")
    for (let i = 0; i < data.length; i++) {
        let curr = data[i]
        const tbody = document.createElement("tbody")
        for (let ii = 0; ii < array.length; ii++) {
            const td = document.createElement("td")
            const node = document.createTextNode(`${curr[array[ii]]}`)
            td.appendChild(node)
            tbody.appendChild(td)
        }
        table.appendChild(tbody)
    }
}