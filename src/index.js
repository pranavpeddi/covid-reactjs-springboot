import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

import * as serviceWorker from './serviceWorker';
import CovidData from './Components/CovidTable'
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter , Route } from 'react-router-dom';

import Accordion from './Components/Accordion';
import Main from './Components/Main'
import Char from './Components/Chart'

ReactDOM.render(

  <BrowserRouter>
  <Route exact path="/table" component={CovidData}></Route>
  <Route exact path="/acc" component={Accordion}></Route>
  <Route exact path="/main" component={Main}></Route>
  <Route exact path="/chart" component={Char}></Route>
</BrowserRouter>
,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
