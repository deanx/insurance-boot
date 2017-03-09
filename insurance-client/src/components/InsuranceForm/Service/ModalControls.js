function setModal(msg) {
  this.setState({ displayLoading: false, displayModal: true, msgModal: msg });
}

function hideModal() {
  this.setState({ displayModal: false });
}

module.exports = { setModal, hideModal }
