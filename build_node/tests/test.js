'use strict';

var test = require('unit.js');
var index = require('../index.js');

describe('Tests index', function() {
  it('verifies successful response', function(done) {
    index.get({ /* event */ }, { /* context */ }, (err, result) => {
      try {
        test.number(result.statusCode).is(200);
        test.string(result.body).contains('Congratulations');
        test.value(result).hasHeader('content-type', 'text/html');
        done();
      } catch(error) {
        done(error);
      }
    });
  });
});
