export default {
  makeValidCurrencyValue: (newValue) => {
    let arrDoubleParts = newValue.split('.');
    if (arrDoubleParts.length > 2) {
      arrDoubleParts.slice(0, arrDoubleParts.length - 2);
      newValue = arrDoubleParts.join('').concat('.');
    } else if (arrDoubleParts.length > 1) {
      arrDoubleParts[arrDoubleParts.length - 1] = arrDoubleParts[arrDoubleParts.length - 1].substring(0, 2);
      newValue = arrDoubleParts.join('.');
    }
    return newValue;
  }
}
