import React from "react";
import { Link } from "react-router-dom";

import logoImage from "../../assets/logo.png";
import reading from "../../assets/reading.png";
import './styles.css';


export default function Login() {
    return (
        <div className="login-container">
            <section className="form">
                <img src={logoImage} alt="Logo DBook" />
                <form >
                    <h1>Entrar</h1>
                    <input placeholder="Nome de Usuário" />
                    <input type="password" placeholder="Senha" />
                    <Link className="button" to="book">Entrar</Link>

                </form>
            </section>
            <img src={reading} alt="Login" />
        </div>
    )
}