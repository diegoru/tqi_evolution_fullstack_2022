import React from "react";
import { FiUploadCloud, FiArrowLeft } from 'react-icons/fi';
import { Link } from "react-router-dom";

import "./styles.css";
import logoImage from "../../assets/logo.png"

export default function NewBook() {

    return (
        <div className="new-book-container">
            <div className="content">
                <section className="form">
                    <div class="wrapper">
                        <div class="file-upload">
                            <input type="file" />
                        <FiUploadCloud size={36} color="#FFFFFF" />
                        </div>
                    </div>
                        <p>Escolha uma imagem...</p>
                    <Link className="back-link" to="/books">
                        <FiArrowLeft size={16} color="#251FC5" />
                         Voltar
                    </Link>
                </section>

                <form>
                    <input type="text" placeholder="Titulo" />
                    <input type="text" placeholder="Author" />
                    <input type="text" placeholder="Editora" />
                    <input type="text" placeholder="Preço" />
                    <input type="text" placeholder="Ano Lançamento" />

                    <button className="button" type="submit">Adicionar</button>
                </form>

            </div>
        </div>
    )

}