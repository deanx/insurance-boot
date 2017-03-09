import React from 'react';
import './Style.css';
import {  Jumbotron,FormGroup, Input, Label, Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import loadingGif from './loading.gif';

const FormElement = (props) => {
 return (<section className='insuranceFormSection'>
          {props.displayLoading ? <Loading type='doubleBounce' /> : <JumboTron {...props} />}
          {props.displayModal ? <MsgModal {...props} /> : ''}
        </section>);
}

const JumboTron = (props) => {
  return(<Jumbotron>
            <ItemValueElement {...props}/>
            <ItemTypeElement/>
            <SendButtonElement {...props}/>
          </Jumbotron>);
}

const ItemValueElement = (props) => {
  return (<FormGroup lang='en-US'>
            <Label for='itemValue'>Item value:</Label>
            <Input id='itemValue' type='text' placeholder='Item value' onChange={props.onItemValueChanged}/>
          </FormGroup>);
}

const ItemTypeElement = (props) => {
  return (<FormGroup>
            <Label for='itemType'>Item Type:</Label>
            <Input id='itemType' type='select'>
              <option value='BICICLE'>Bike</option>
              <option value='JEWELRY'>Jewelry</option>
              <option value='ELECTRONICS'>Electronics</option>
              <option value='SPORTS_EQUIPMENT'>Sports Equipment</option>
            </Input>
          </FormGroup>);
}

const SendButtonElement = (props) => {
  return (<FormGroup>
            <Button className='sendButton' color='primary' onClick={props.onButtonClick}>Send</Button>
          </FormGroup>);
}

const Loading = () => {
  return (<img src={loadingGif} alt='loading' />)
}

const MsgModal = (props) => {
  return (<Modal isOpen={props.displayModal} className={props.className}>
          <ModalHeader>Insurance calculation</ModalHeader>
          <ModalBody>
           {props.msgModal}
          </ModalBody>
          <ModalFooter>
            <Button color="primary" onClick={props.hideModal}>Close...</Button>{' '}
          </ModalFooter>
  </Modal>);
}


export default FormElement;