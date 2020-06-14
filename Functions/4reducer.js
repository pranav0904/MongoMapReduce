// Reducer function for Number of times each movie was tagged
function(key,values){
                     var result = {count: 0};
                     for(i=0; i< values.length; i++){
                     		result.count += values[i].count; 
                     }
                     return result;
}