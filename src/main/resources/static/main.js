<!--Shameless copy&paste from https://developer.mozilla.org/en-US/docs/Learn/HTML/Forms/Sending_forms_through_JavaScript-->
    window.addEventListener("load", function () {
      function sendData() {
        var XHR = new XMLHttpRequest();

        // Bind the FormData object and the form element
        var FD = new FormData(form);

        // Define what happens on successful data submission
        XHR.addEventListener("load", function(event) {
            var resultDiv = document.getElementById("resultBox");
            resultDiv.classList.remove("hidden");
            var resultValueBox = document.getElementById("resultValueId");
            if (event.currentTarget.status === 200){
                resultValueBox.innerHTML = JSON.parse(event.currentTarget.responseText).value;
            } else if (event.currentTarget.status === 500){
                resultValueBox.innerHTML = JSON.parse(event.currentTarget.responseText).message;
            }
        });

        // Define what happens in case of error
        XHR.addEventListener("error", function(event) {
        console.log("boom")
        console.log(event)
          alert('Oops! Something went wrong.');
        });

        // Set up our request
        XHR.open("POST", "api/calculate");

        // The data sent is what the user provided in the form
        XHR.send(FD);
      }

      // Access the form element...
      var form = document.getElementById("distanceInputFormId");

      // ...and take over its submit event.
      form.addEventListener("submit", function (event) {
        event.preventDefault();

        sendData();
      });
    });