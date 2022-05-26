from flask import Flask, jsonify, request, make_response, abort
from model.categoriaModel import categoria, categoriaEncoder
from connectionDb import *
from db import getAllCategoria, getAllProduto
from flask_cors import CORS

server = Flask(__name__)
CORS(server)
server.config['DEBUG'] = True
server.json_encoder = categoriaEncoder

@server.errorhandler(404)
def not_found(error):
    return make_response({'Status': 404,
                         'Error': 'Conteudo nao foi encontrado'}, 404)


#CATEGORIAS ROUTES

@server.route('/api/v1/resource/categoria', methods=['GET'])
def listAllCat():
    db = getAllCategoria()
    return jsonify({'Categorias': db})

@server.route('/api/v1/resource/categoria/<int:id>', methods=['GET'])
def listById(id):
    for categoria in db:
        if id == categoria['id']:
            return jsonify(categoria)
    abort(404)

#PRODUTOS ROUTES
@server.route('/api/v1/resource/produto', methods=['GET'])
def listAllProd():
    db = getAllProduto()
    return jsonify({'Produtos': db})

server.run()