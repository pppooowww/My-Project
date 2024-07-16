const likeBtn = document.getElementById('likeBtn');
const likeCount = document.getElementById('likeCount');
const storeName = document.getElementsByClassName('storeName');

likeBtn.onclick = () => {
    fetch('/like', {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify("storeName", storeName.toString)
    }).then(response => response.json());
}