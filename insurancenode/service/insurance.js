function insuranceCalculator(insuranceType, itemValue) {
  return (insuranceType.risk / 1000 * itemValue).toFixed(2);
}

function validateRequest(insuranceType, itemValue) {
  if (!insuranceType) return 'invalid insurance type!';
  else if (!itemValue || isNaN(itemValue)) return 'invalid item value!';
  else if (itemValue < insuranceType.minPrice) return 'price lowest than allowed';
  else if (itemValue > insuranceType.maxPrice) return 'price highest than allowed';
}

module.exports = {
  insuranceCalculator,
  validateRequest
}
