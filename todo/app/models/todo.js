var mongoose = require('mongoose');

module.exports = mongoose.model('Todo', {
	text : String,
	cat : String,
	done : Boolean
});