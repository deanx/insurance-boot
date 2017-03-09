import React, { Component } from 'react';
import axios from 'axios';

import FormElement from './Component';
import MakeValidCurrencyValue from './Service/Currency';
import ModalControls from './Service/ModalControls';
import Request from './Service/Request';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  calculateInsurance() {
    const itemType = document.getElementById('itemType').value;
    const itemValue = document.getElementById('itemValue').value;

    if (itemType && itemValue) {
      const requestURL = Request.buildRequestURL(this.props.properties['api.url'], this.props.properties['resource.insurance']);
      const requestData = { itemValue, itemType };

      this.setState({ displayLoading: true });
      axios.post(requestURL, requestData, { headers: { 'content-type': 'application/json' } })
        .then(response => ModalControls.setModal.call(this, Request.buildSuccessMessage(response)))
        .catch(err => ModalControls.setModal.call(this, Request.buildErrorMessage(err)));
   }
  }

  fixItemValue(event) {
    let newValue = event.target.value;
    newValue = newValue.replace(',', '.');
    const formatedValue = MakeValidCurrencyValue.makeValidCurrencyValue(newValue);

    if (isNaN(formatedValue)) {
      newValue = 0;
    }
    event.target.value = formatedValue;
  }





  render = () => <FormElement
    onButtonClick={this.calculateInsurance.bind(this)}
    onItemValueChanged={this.fixItemValue.bind(this)}
    hideModal={ModalControls.hideModal.bind(this)}
    {...this.state}
  />
}

export default App;
