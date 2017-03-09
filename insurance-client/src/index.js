import React from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.css';

import './index.css';
import App from './components/InsuranceForm/Container';
import properties from './properties';

ReactDOM.render(React.createElement(App, { properties }), document.getElementById('root'));
