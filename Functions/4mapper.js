// Mapper function for Number of times each movie was tagged

function(){
emit(this.MovieID, {count:1, id: this.Tag});
}