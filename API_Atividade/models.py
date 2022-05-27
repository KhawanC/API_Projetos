
class Pessoas:
    def __init__(self, id, nome, idade):
        self.id = id
        self.nome = nome
        self.idade = idade
        
class Atividade:
    def __init__(self, id, nome, pessoa_id):
        self.id = id
        self.nome = nome
        self.pessoa_id = pessoa_id

if __name__=="__main__":
    pass