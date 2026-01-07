
import {
  Box,
  Container,
  TextField,
  Typography,
  FormControl,
  InputLabel,
  Select,
  MenuItem,
  CircularProgress,
  Button
} from '@mui/material'
import './App.css'
import { useState } from 'react'
import axios from 'axios';

function App() {
  const [emailContent, setEmailContent] = useState('');
  const [tone, setTone] = useState('')
  const [generatedReply, setGeneratedReply] = useState('')
  const [loading, setLoading] = useState(false)

  const handleSubmit = async () => {

      setLoading(true);
      try {
        const response = await axios.post("http://localhost:8080/api/email/generate",
          {emailContent,
            tone
          });
          setGeneratedReply(typeof response.data === 'string' ? 
            response.data : JSON.stringify(response.data)
          )
      } catch (error){
        
      }finally{
          setLoading(false);
      }
  };



  return (
    <>
      <Container maxWidth="md" sx={{ py: 4 }}>
        <Typography variant='h3' component='h1' gutterBottom>Email Reply Generator</Typography>

        <Box sx={{ mx: 3 }}>

          <TextField
            fullWidth
            multiline
            rows={6}
            variant='outlined'
            label="Original Email Content."
            value={emailContent || ''}
            onChange={(e) => setEmailContent(e.target.value)}
            sx={{ mb: 2 }}
          >
          </TextField>

          <FormControl fullWidth>
            <InputLabel id="demo-simple-select-label">Tone (Optional)</InputLabel>
            <Select

              value={tone}
              label="tone (Optional)"
              onChange={(e) => setTone(e.target.value)}
            >
              <MenuItem value="">None</MenuItem>
              <MenuItem value="casual">Casual</MenuItem>
              <MenuItem value="professional">Professional</MenuItem>
              <MenuItem value="friendly">Friendly</MenuItem>
            </Select>
          </FormControl>

          <Button variant="contained"
            onClick={handleSubmit}
            disabled={!emailContent || loading}
            sx={{ my: 2 }}>
            {loading ? <CircularProgress size={24} /> : "Generate Reply"}
          </Button>
        </Box>

        <Box sx={{ mx: 3 }}>

          <TextField
            fullWidth
            multiline
            rows={6}
            variant='outlined'
            value={generatedReply || ''}
            inputProps={{ readOnly: true }}
            sx={{ mb: 2 }}
          >
          </TextField>

          <Button variant="contained"
            onClick={() => navigator.clipboard.writeText(generatedReply)}
            sx={{ my: 2 }}>
            copy to clipboard
          </Button>

        </Box>

      </Container>
    </>
  )
}

export default App
