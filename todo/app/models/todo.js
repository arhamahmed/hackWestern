var mongoose = require('mongoose');

module.exports = mongoose.model('Todo', {
	text : String,
	query : String,
	done : Boolean,
	titleScores : [],
	sizeScores : []
});