

var n = 0; 
function count(obj) { 
   if (obj.checked) 
      if (n<3) n++; 
      else { 
         alert("最多只能勾3個"); 
         return false; 
      } 
   else n--; 
   document.getElementById("t1").innerText = n; 
} 
function check() { 
   if (n<2) { 
      alert("最少要勾2個"); 
      return false; 
   } 
} 
