// Mapper function for Number of Movies per rating
function(){
emit(this.Rating, {MovieCount:1, id: this.MovieID});
}