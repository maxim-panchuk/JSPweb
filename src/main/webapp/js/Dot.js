class Dot {
    static type = "Dot"

    constructor (options) {
        this.name =     options.name
        this.x =        options.x
        this.y =        options.y
    }

    sout() {
        console.log("Name: " + this.name + " x: " + this.x + " y: " + this.y)
    }
}