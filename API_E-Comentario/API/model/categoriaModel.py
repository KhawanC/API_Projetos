from flask.json import JSONEncoder

class categoria(object):
    def __init__(self, id, nome_cat):
        self.id = id
        self.nome_cat= nome_cat

class categoriaEncoder(JSONEncoder):
    def default(self, obj):
        if isinstance(obj, categoria):
            return obj.__dict__
        return super(
            categoriaEncoder, self
        ).default(obj)



