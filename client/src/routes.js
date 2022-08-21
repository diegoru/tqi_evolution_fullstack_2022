import React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";

import Book from "./pages/Books";
import Login from "./pages/Login";
import NewBook from "./pages/NewBook";

export default function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Login} />
                <Route path="/books" component={Book} />
                <Route path="/book/new" component={NewBook} />
            </Switch>
        </BrowserRouter>
    )   
}
