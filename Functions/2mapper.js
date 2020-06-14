// Mapper function for Number of Movies per genre 
function(){
var genre = this.Genre.split('|');
for (var i = 0; i < genre.length; i++) {
	var key = genre[i];
        var value = { count: 1 };
        emit(key, value); }
}