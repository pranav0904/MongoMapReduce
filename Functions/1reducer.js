//Reducer function for Number of Movies released per year

function(key,values){
                var result = {count: 0};
                for(i=0; i< values.length; i++){
                   result.count += values[i].count; 
                }
                return result;
}