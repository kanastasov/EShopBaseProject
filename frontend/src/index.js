import React from 'react';
import ReactDOM from 'react-dom';
import { Provider} from 'react-redux'
import store from './store'
import './bootstrap.min.css';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter } from 'react-router-dom';
import { createBrowserHistory } from "history";
const history = createBrowserHistory();

ReactDOM.render(
  <Provider store={store}>
    <BrowserRouter history={history}>
      <App />
    </BrowserRouter>
    </Provider>,
  document.getElementById('root')
);


reportWebVitals();