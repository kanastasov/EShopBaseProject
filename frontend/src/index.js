
import React from 'react';
import ReactDOM from 'react-dom';
import './bootstrap.min.css';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter } from 'react-router-dom';
import { createBrowserHistory } from "history";
const history = createBrowserHistory();

ReactDOM.render(

    <BrowserRouter history={history}>
      <App />
    </BrowserRouter>
   ,
  document.getElementById('root')
);


reportWebVitals();