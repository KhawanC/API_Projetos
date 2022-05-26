const cardContainer = document.getElementById('container')
let info

const criarCard = () => {
    for(i = 0; i < info.Produtos.length; i++) {

        const html = `
        <div class="card">
                <div class="img">
                    <img src="${info.Produtos[i].img_prod}" alt="">
                </div>
                <div class="nome_prod">
                    <h2>${info.Produtos[i].nome_prod}</h2>
                </div>
                <div class="abrir_coment">
                    <a href="">Comentar</a>
                </div>    
            </div>`;

        cardContainer.innerHTML += html
    }
}

function makeRequest() {
    const url = 'http://127.0.0.1:5000/api/v1/resource/produto'
    fetch(url)
    .then(response => response.json())  
    .then(json => {
        info = json;
        criarCard();
    });
}

makeRequest();
