import { useState, useEffect } from 'react';

const Posts = () => {
  //const[상태값, 상태를 바꿀수있는 메서드] = 매개변수값; 반환값 배열
  const [items, setItems] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);  //로딩중
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((res) => res.json())
      .then((posts) => {
        setItems(posts);
        setLoading(false); // 로딩끝
      });
  }, []);

  return (
    <>
      <h1>게시글 목록</h1>
      <ul>
        {loading && <div>loading....</div>}
        {items && items.map(({ id, title }) => <li key={id}>{title}</li>)}
      </ul>
    </>
  );
};

export default Posts;