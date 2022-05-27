from fileinput import close
from models import Pessoas
import psycopg2

def initDb():
    connection = psycopg2.connect(
        host = "localhost",
        database = "atividades",
        user = "kaua",
        password = "220104",
        port = "5432")
    return connection

def closeDb():
    connection = initDb
    close = connection.close()
    return close

def consultarPessoas():
    pessoas = []
    cur = con.cursor()
    cur.execute("select * from usuario")
    rows = cur.fetchall()
    for i in range(len(rows)):
        pessoa = Pessoas(rows[i][0], rows[i][1], rows[i][2])
        pessoas.append(pessoa.__dict__)
    return pessoas

def adicionarPessoas(nome, idade):
    cur = con.cursor()
    cur.execute("""insert into usuario(nome, idade)
values(
%s,
%s
);""", (nome, idade))
    con.commit()
    

if __name__=="__main__":
    con = initDb()

    adicionarPessoas('Legogas', 12)
    pessoas = consultarPessoas()

    print(pessoas)

    con.close()