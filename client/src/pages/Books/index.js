import React from "react";
import { FiPower, FiEdit,  FiTrash2 } from 'react-icons/fi';
import { Link } from "react-router-dom";

import logoImage from "../../assets/logo.png";
import './styles.css';

import imgLivro1 from "../../assets/livros/java-efetivo.jpg"
import imgLivro2 from "../../assets/livros/java-como-programar.jpg"
import imgLivro3 from "../../assets/livros/use-cabeca-java.jpg"
import imgLivro4 from "../../assets/livros/spring-mvc.jpg"
import imgLivro5 from "../../assets/livros/spring-boot.jpg"
import imgLivro6 from "../../assets/livros/the-road-react.jpg"

export default function Books() {
    return (
        <div className="book-container">
            <header>
                <img src={logoImage} alt="Logo DBook" />
                <span>Seja bem-vindo, <strong>Diego</strong>!</span>
                <Link className="button" to="book/new">Adicionar Novo Livro</Link>
                <button type="button">
                    <FiPower size={18} color="#251FC5" />
                </button>
            </header>

            <h1>Livros Cadastrados</h1>
            <ul>
                <li>
                    <strong>Titulo:</strong>
                    <p>Java Efetivo</p>
                    <strong>Autor:</strong>
                    <p>Joshua Bloch</p>
                    <strong>Editora:</strong>
                    <p>Alta Books</p>
                    <strong>Preço:</strong>
                    <p>Java R$ 90,00</p>
                    <strong>Ano</strong>
                    <p>2019</p>

                    <button type="button">
                    <FiEdit size={20} color="#251FC5" />
                    </button>
                    <button type="button">
                    <FiTrash2 size={20} color="#251FC5" />
                    </button>
                    <img className="img-book" src={imgLivro1} alt="" />
                </li>
            
                <li>
                    <strong>Titulo:</strong>
                    <p>Java - Como Programar</p>
                    <strong>Autor:</strong>
                    <p>Harvey M. Deitel</p>
                    <strong>Editora:</strong>
                    <p>Pearson Education do Brasil</p>
                    <strong>Preço:</strong>
                    <p>Java R$ 190,00</p>
                    <strong>Ano</strong>
                    <p>2005</p>

                    <button type="button">
                    <FiEdit size={20} color="#251FC5" />
                    </button>
                    <button type="button">
                    <FiTrash2 size={20} color="#251FC5" />
                    </button>
                    <img className="img-book" src={imgLivro2} alt="" />
                </li>
            
                <li>
                    <strong>Titulo:</strong>
                    <p>Use a Cabeça! Java</p>
                    <strong>Autor:</strong>
                    <p>Kathy Sierra</p>
                    <strong>Editora:</strong>
                    <p>Alta Books</p>
                    <strong>Preço:</strong>
                    <p>Java R$ 290,00</p>
                    <strong>Ano</strong>
                    <p>2009</p>

                    <button type="button">
                    <FiEdit size={20} color="#251FC5" />
                    </button>
                    <button type="button">
                    <FiTrash2 size={20} color="#251FC5" />
                    </button>
                    <img className="img-book" src={imgLivro3} alt="" />
                </li>
               
                <li>
                    <strong>Titulo:</strong>
                    <p>Spring MVC - Domine o principal framework web Java</p>
                    <strong>Autor:</strong>
                    <p>Alberto Souza</p>
                    <strong>Editora:</strong>
                    <p>Casa do Código</p>
                    <strong>Preço:</strong>
                    <p>Java R$ 75,00</p>
                    <strong>Ano</strong>
                    <p>2015</p>

                    <button type="button">
                    <FiEdit size={20} color="#251FC5" />
                    </button>
                    <button type="button">
                    <FiTrash2 size={20} color="#251FC5" />
                    </button>
                    <img className="img-book" src={imgLivro4} alt="" />
                </li>
                
                <li>
                    <strong>Titulo:</strong>
                    <p>Spring Boot - Acelere o desenvolvimento de microsservicos</p>
                    <strong>Autor:</strong>
                    <p>Fernando Boaglio</p>
                    <strong>Editora:</strong>
                    <p>Casa do Código</p>
                    <strong>Preço:</strong>
                    <p>Java R$ 95,00</p>
                    <strong>Ano</strong>
                    <p>2018</p>

                    <button type="button">
                    <FiEdit size={20} color="#251FC5" />
                    </button>
                    <button type="button">
                    <FiTrash2 size={20} color="#251FC5" />
                    </button>
                    <img className="img-book" src={imgLivro5} alt="" />
                </li>
                
                <li>
                    <strong>Titulo:</strong>
                    <p>The Road to learn React</p>
                    <strong>Autor:</strong>
                    <p>Robin Wieruch</p>
                    <strong>Editora:</strong>
                    <p>CreateSpace Independent</p>
                    <strong>Preço:</strong>
                    <p>Java R$ 125,00</p>
                    <strong>Ano</strong>
                    <p>2018</p>

                    <button type="button">
                    <FiEdit size={20} color="#251FC5" />
                    </button>
                    <button type="button">
                    <FiTrash2 size={20} color="#251FC5" />
                    </button>
                    <img className="img-book" src={imgLivro6} alt="" />
                </li>
            </ul>

            <button className="button">Ver Mais</button>
        </div>
    )
}