function connectToServer(server, events, divid) {
    if (server === null) {
        alert("The server address cannot be null ...");
        throw new Error("The server address cannot be null ...");
    }
    if (server === 'undefined') {
        alert("You have to specify the server address ...");
        throw new Error("You have to specify the server address ...");
    }

    if (!!window.EventSource) {
        var eventSource = new EventSource(server);

        addEvents(eventSource, events, divid);
    } else {
        // Ops!
        alert("Cannot subscribe to this event stream ...");
        throw new Error("Cannot subscribe to this event stream ...");
    }
}

function addEvents(source, events, divid) {
    for (var i in events) {
        if (events[i] === "error") {
            source.addEventListener('error', function(e) {
                source.close();
                //if (e.readyState === EventSource.CLOSED) {
                //console.log(e.data);
                document.getElementById(divid).innerHTML += e.data+"<br/>";
                //}
            }, false);
        } else if (events[i] === "open") {
            source.addEventListener('open', function(e) {
                //console.log(e.data);
                document.getElementById(divid).innerHTML += e.data+"<br/>";
            }, false);
        } else {
            source.addEventListener(events[i], function(e) {
                //console.log(e.data);
                document.getElementById(divid).innerHTML += e.data+"<br/>";
            }, false);
        }
    }
}



