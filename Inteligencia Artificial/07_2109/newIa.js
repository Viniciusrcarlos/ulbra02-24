const perguntas = [
    {
        pergunta: "É Homem?",
        subElemento: {
            sim: {
                pergunta: "Ele joga futebol?",
                subElemento: {
                    sim: {
                        pergunta: "Ele já ganhou uma Copa do Mundo?",
                        subElemento: {
                            sim: "Pelé",
                            nao: "Neymar"
                        }
                    },
                    nao: {
                        pergunta: "Ele é piloto de corrida?",
                        subElemento: {
                            sim: "Ayrton Senna",
                            nao: "Michael Jordan"
                        }
                    }
                }
            },
            nao: {
                pergunta: "Ele é famoso no cinema?",
                subElemento: {
                    sim: {
                        pergunta: "Ele é um herói de ação?",
                        subElemento: {
                            sim: "Keanu Reeves",
                            nao: "Leonardo DiCaprio"
                        }
                    },
                    nao: {
                        pergunta: "Ele é cientista?",
                        subElemento: {
                            sim: "Albert Einstein",
                            nao: "Sigmund Freud"
                        }
                    }
                }
            }
        }
    },
    {
        pergunta: "É Mulher?",
        subElemento: {
            sim: {
                pergunta: "Ela é modelo?",
                subElemento: {
                    sim: "Gisele Bündchen",
                    nao: {
                        pergunta: "Ela é atriz?",
                        subElemento: {
                            sim: {
                                pergunta: "Ela é famosa por filmes de ação?",
                                subElemento: {
                                    sim: "Scarlett Johansson",
                                    nao: "Margot Robbie"
                                }
                            },
                            nao: {
                                pergunta: "Ela é uma política famosa?",
                                subElemento: {
                                    sim: "Angela Merkel",
                                    nao: "Marie Curie"
                                }
                            }
                        }
                    }
                }
            },
            nao: {
                pergunta: "É uma cientista famosa?",
                subElemento: {
                    sim: "Ada Lovelace",
                    nao: {
                        pergunta: "É uma figura histórica?",
                        subElemento: {
                            sim: "Cleópatra",
                            nao: "Joana D'Arc"
                        }
                    }
                }
            }
        }
    },
    {
        pergunta: "É um personagem animado?",
        subElemento: {
            sim: {
                pergunta: "Ele é do Dragon Ball?",
                subElemento: {
                    sim: "Goku",
                    nao: {
                        pergunta: "Ele é um ninja?",
                        subElemento: {
                            sim: "Naruto",
                            nao: "Mickey Mouse"
                        }
                    }
                }
            },
            nao: {
                pergunta: "Ele é um personagem de quadrinhos?",
                subElemento: {
                    sim: {
                        pergunta: "Ele é da Marvel?",
                        subElemento: {
                            sim: "Homem-Aranha",
                            nao: "Superman"
                        }
                    },
                    nao: {
                        pergunta: "Ele é de um filme de animação?",
                        subElemento: {
                            sim: "Shrek",
                            nao: "Sonic"
                        }
                    }
                }
            }
        }
    },
    {
        pergunta: "É um animal?",
        subElemento: {
            sim: {
                pergunta: "Ele é o melhor amigo do homem?",
                subElemento: {
                    sim: "Cachorro",
                    nao: {
                        pergunta: "Ele é selvagem?",
                        subElemento: {
                            sim: {
                                pergunta: "Ele vive na selva?",
                                subElemento: {
                                    sim: "Leão",
                                    nao: "Urso Polar"
                                }
                            },
                            nao: {
                                pergunta: "Ele é um animal de fazenda?",
                                subElemento: {
                                    sim: "Vaca",
                                    nao: "Cavalo"
                                }
                            }
                        }
                    }
                }
            },
            nao: {
                pergunta: "É uma planta?",
                subElemento: {
                    sim: {
                        pergunta: "É uma árvore?",
                        subElemento: {
                            sim: "Árvore",
                            nao: "Flor"
                        }
                    },
                    nao: {
                        pergunta: "É um objeto natural?",
                        subElemento: {
                            sim: "Montanha",
                            nao: "Oceano"
                        }
                    }
                }
            }
        }
    }
];

arrayDeRespostasPossiveis = [
    "Neymar", "Ayrton Senna", "Michael Jordan", "Pelé", "Keanu Reeves", "Leonardo DiCaprio",
    "Albert Einstein", "Sigmund Freud", "Gisele Bündchen", "Scarlett Johansson", "Angela Merkel",
    "Marie Curie", "Ada Lovelace", "Cleópatra", "Joana D'Arc", "Goku", "Naruto", "Mickey Mouse",
    "Homem-Aranha", "Superman", "Shrek", "Sonic", "Cachorro", "Leão", "Urso Polar", "Vaca", "Cavalo",
    "Árvore", "Flor", "Montanha", "Oceano"
];

console.log("Pense em uma das opções abaixo para eu tentar adivinhar:");
arrayDeRespostasPossiveis.forEach(resposta => {
    console.log(resposta);
});

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

async function fazPergunta(pergunta) {
    return new Promise((resolve) => {
        rl.question(pergunta, (resposta) => {
            resolve(resposta);
        });
    });
}

async function iniciarPerguntas(perguntas) {
    for (const [key, value] of Object.entries(perguntas)) {
        let resposta = await fazPergunta(value.pergunta + ": 1 para SIM, 2 para NÃO\n\n");
        if (resposta == 1) {
            if (typeof value.subElemento.sim === "string") {
                console.log("Você pensou em: " + value.subElemento.sim);
                rl.close();
                return;
            } else {
                await iniciarPerguntas([value.subElemento.sim]);
                return;
            }
        } else if (resposta == 2) {
            if (typeof value.subElemento.nao === "string") {
                console.log("Você pensou em: " + value.subElemento.nao);
                rl.close();
                return;
            } else {
                await iniciarPerguntas([value.subElemento.nao]);
                return;
            }
        }
    }
}

iniciarPerguntas(perguntas);