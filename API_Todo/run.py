from flask import Flask, jsonify, request, json

app = Flask(__name__)

devs = [{
        'id': 0,
        'nome': 'Kaua',
        'habilidades':['Python', 'Flask']
    },{
        'id': 2,
        'nome': 'Roberto',
        'habilidades':['Golang', 'Viper']
    }]


@app.route('/devs/<int:id>', methods=['GET', 'PUT'])
def desenvolvedor(id):
    if request.method == 'GET': 
        return devs[id]
    elif request.method == 'PUT':
        print(devs[0])
        dados = json.loads(request.data) 
        devs[id] = dados
        return jsonify(dados)

@app.route('/getAllDevs', methods=['GET'])
def AllDesenvolvedores():
    print(type(devs))
    return jsonify(devs)

if __name__=='__main__':
    app.run(debug=True)