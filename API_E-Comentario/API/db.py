from connectionDb import *
from model.categoriaModel import categoria
from model.produtosModel import produto
import json

#CATEGORIA QUERY
def getAllCategoria():
    db = []
    resp = queryGetAllCategoria()
    for i in range(len(resp)):
        user = categoria(resp[i][0], resp[i][1])
        json_user = json.loads(json.dumps(user.__dict__))
        db.append(json_user)
    return db

#PRODUTO QUERY
def getAllProduto():
    db = []
    resp = queryGetAllProdutos()
    for i in range(len(resp)):
        user = produto(resp[i][0], resp[i][1], resp[i][2], resp[i][3], resp[i][4], resp[i][5])
        json_user = json.loads(json.dumps(user.__dict__))
        db.append(json_user)
    return db

    
