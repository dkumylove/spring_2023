import React, { useState, useEffect, useRef } from 'react';

const LoginForm = () => {
    
  const [form, setForm] = useState({
    userId: '',
    userPw: '',
  });

  const [message, setMessage] = useState('');

  const countRef = useRef(1);

  const onSubmit = (e) => {
    e.preventDefault();

    countRef.current++;
    console.log(countRef.current);

    try {
      for (const key in form) {
        const message =
          (key === 'userId' ? '아이디' : '비밀번호') + '를 입력하세요.';
        if (!form[key].trim()) {
          throw new Error(message);
        }
      }
    } catch (err) {
      setMessage(err.message);
    }
  };

  const { userId, userPw } = form;

  const onChange = (e) => {
    setForm({ ...form, [e.currentTarget.name]: e.currentTarget.value });
  };

  //let userIdEl = React.createRef();
  let userIdEl = useRef();

  useEffect(() => {
    //userIdEl.focus();
    //console.log(userIdEl.current);
    userIdEl.current.focus();
  }, [userIdEl]);

  return (
    <form onSubmit={onSubmit}>
      <dl>
        <dt>아이디</dt>
        <dd>
          <input
            //ref={(ref) => (userIdEl = ref)}
            ref={userIdEl}
            type="text"
            name="userId"
            onChange={onChange}
            value={userId}
          />
        </dd>
      </dl>
      <dl>
        <dt>비밀번호</dt>
        <dd>
          <input
            type="password"
            name="userPw"
            onChange={onChange}
            value={userPw}
          />
        </dd>
      </dl>
      {message && <div>{message}</div>}
      <button type="submit">로그인</button>
    </form>
  );
};

export default LoginForm;