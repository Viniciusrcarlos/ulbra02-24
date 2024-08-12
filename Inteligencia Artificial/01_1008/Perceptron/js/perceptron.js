
class Perceptron {
    weights = [0,0]

    constructor() {
        for (let i = 0; i < this.weights.length; i++) {
            this.weights[1] = random(-1, 1)
        }
    }
}