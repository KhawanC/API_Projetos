from flask.json import JSONEncoder

class produto(object):
    def __init__(self, id, cat_prod, nome_prod, desc_prod, preco_prod, img_prod):
        self.id = id
        self.cat_prod = cat_prod
        self.nome_prod= nome_prod
        self.desc_prod= desc_prod
        self.preco_prod= preco_prod
        self.img_prod= img_prod

class produtoEncoder(JSONEncoder):
    def default(self, obj):
        if isinstance(obj, produto):
            return obj.__dict__
        return super(
            produtoEncoder, self
        ).default(obj)



