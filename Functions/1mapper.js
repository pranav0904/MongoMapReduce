// Mapper function for Number of Movies released per year
function(){
	var str = this.Title;
	var matches = str.match(/(\d+)/);
	emit(matches[0],{count:1, id: this.MovieID});
}