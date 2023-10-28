// Function to update the time by making a request to the UpdateTime servlet
        function updateTime() {
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    // Update the content of the <span> with the received time
                    document.getElementById("thetime").textContent = " " + xhr.responseText;
                }
            };

            xhr.open("GET", "UpdateTime", true);
            xhr.send();
        }

        // Update the time initially and then refresh every second
        updateTime();
        setInterval(updateTime, 1000); // Refresh every 1000 milliseconds (1 second)

