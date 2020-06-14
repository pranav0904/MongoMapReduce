// Reducer function for Number of Movies per rating
function(key,values){
                     var result = {MovieCount: 0};
                     for(i=0; i< values.length; i++){
                     		result.MovieCount += values[i].MovieCount; 
                     }
                     return result;
}