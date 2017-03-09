const express = require('express');
const router = express.Router();

const insuranceService = require('../service/insurance');
const insuranceModel = require('../model/insurance');

router.post('/', function(req, res, next) {
  const itemType = req.body.itemType;
  const itemValue = req.body.itemValue;

  const errMsg = insuranceService.validateRequest(insuranceModel[itemType], itemValue);
  if (errMsg) {
    return res.status(400).json({ msg: errMsg });
  }

  res.json({ value: insuranceService.insuranceCalculator(insuranceModel[itemType], itemValue) });
});

module.exports = router;
