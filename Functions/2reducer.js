// Reducer function for Number of Movies per genre 
function(key,values){
	reducedVal = {count: 0};
        for (var i = 0; i < values.length; i++) {
        	reducedVal.count += values[i].count;
        }
	return reducedVal;
}