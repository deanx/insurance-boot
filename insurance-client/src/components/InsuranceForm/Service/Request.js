export default {
  buildRequestURL: (apiURL, resourceURL) => {
    return `${apiURL}/${resourceURL}`;
  },

  buildSuccessMessage: (response) => {
    return `Your insurance value: ${response.data.value}`;
  },

  buildErrorMessage: (err) => {
    return `Error: ${err.message}`;
  }
}
